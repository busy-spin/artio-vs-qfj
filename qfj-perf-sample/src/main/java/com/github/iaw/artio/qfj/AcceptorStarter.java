package com.github.iaw.artio.qfj;

import lombok.extern.slf4j.Slf4j;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.MessageFactory;
import quickfix.NoopStoreFactory;
import quickfix.SLF4JLogFactory;
import quickfix.ScreenLogFactory;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.field.ClOrdID;
import quickfix.field.HandlInst;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.field.TransactTime;
import quickfix.fix44.NewOrderSingle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
public class AcceptorStarter {

    public static void main(String[] args) throws IOException, ConfigError, InterruptedException {
        InputStream inputStream = null;
        if (args.length == 0) {
            inputStream = AcceptorStarter.class.getResourceAsStream("acceptor.cfg");
        } else if (args.length == 1) {
            inputStream = new FileInputStream(args[0]);
        }
        if (inputStream == null) {
            System.out.println("usage: " + AcceptorStarter.class.getName() + " [configFile].");
            return;
        }

        SessionSettings settings = new SessionSettings(inputStream);
        inputStream.close();

        MessageFactory messageFactory = new DefaultMessageFactory();

        NewOrderSingle newOrderSingle = new NewOrderSingle(
                new ClOrdID(UUID.randomUUID().toString()), new Side(Side.BUY),
                new TransactTime(), new OrdType(OrdType.LIMIT));
        newOrderSingle.set(new OrderQty(100_000));
        newOrderSingle.set(new Symbol("BNA"));
        newOrderSingle.set(new HandlInst('1'));

        AcceptorSampleApp application = new AcceptorSampleApp();
        SocketAcceptor acceptor = new SocketAcceptor(application, new NoopStoreFactory(), settings, new ScreenLogFactory(settings),
                messageFactory);
        acceptor.start();

        long startTime = System.currentTimeMillis();
        long waitTime = 1000L;
        long throughput = 25_000;

        long counterInThisWindow = 0;

        while (true) {

            if (application.getSessionID() != null) {
                try {
                    boolean startNewWindow = System.currentTimeMillis() > (startTime + waitTime);
                    if (startNewWindow) {
                        log.info("Total in this window = [{}]", counterInThisWindow);
                        counterInThisWindow = 0;
                        startTime = System.currentTimeMillis();
                    }

                    if (counterInThisWindow >= throughput) {
                        continue;
                    }

                    counterInThisWindow++;


                    Session.sendToTarget(newOrderSingle, application.getSessionID());
                } catch (SessionNotFound e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
