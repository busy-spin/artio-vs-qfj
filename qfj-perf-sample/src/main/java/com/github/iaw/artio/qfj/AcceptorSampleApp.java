package com.github.iaw.artio.qfj;

import lombok.Getter;
import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.UnsupportedMessageType;
import quickfix.field.ClOrdID;
import quickfix.field.HandlInst;
import quickfix.field.MsgType;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.field.TransactTime;
import quickfix.fix44.MessageCracker;
import quickfix.fix44.NewOrderSingle;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class AcceptorSampleApp extends MessageCracker implements Application {

    private final AtomicBoolean startFiring = new AtomicBoolean(false);

    @Getter
    private SessionID sessionID;
    public AcceptorSampleApp() {
    }

    @Override
    public void onCreate(SessionID sessionId) {

    }

    @Override
    public void onLogon(SessionID sessionId) {
        this.sessionID = sessionId;
    }

    @Override
    public void onLogout(SessionID sessionId) {
        this.sessionID = null;
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        try {
            String msgType = message.getHeader().getString(MsgType.FIELD);
            if (MsgType.HEARTBEAT.equals(msgType) && startFiring.compareAndSet(false, true)) {
            }
        } catch (Exception e) {
            System.out.println("35 field not found in message " + message);
            e.printStackTrace();
        }

    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }


}
