package com.github.iaw.artio;

import baseline.CarDecoder;
import baseline.CarEncoder;
import baseline.MessageHeaderDecoder;
import baseline.MessageHeaderEncoder;
import baseline.Model;
import org.agrona.concurrent.UnsafeBuffer;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
        CarEncoder carEncoder = new CarEncoder();

        UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(4096));

        carEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
        carEncoder.serialNumber(1);
        carEncoder.activationCode("ABCD");
        carEncoder.code(Model.A);
        carEncoder.manufacturer("BMW");

        int encodedLength = carEncoder.encodedLength() + headerEncoder.encodedLength();


        System.out.println("Header length " + headerEncoder.encodedLength());
        System.out.println("Block length " + carEncoder.encodedLength());

        MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
        CarDecoder carDecoder = new CarDecoder();

        messageHeaderDecoder.wrap(unsafeBuffer, 0);

        int blockLength = messageHeaderDecoder.blockLength();
        System.out.println("Decoder block length " + blockLength);
        int actingVersion = messageHeaderDecoder.version();
        System.out.println("Decoder acting version " + actingVersion);
        int headerLength = messageHeaderDecoder.encodedLength();
        System.out.println("Decoder header length " + headerLength);

        carDecoder.wrap(unsafeBuffer, headerLength, blockLength, actingVersion);

        System.out.println(carDecoder.activationCode());
        System.out.println(carDecoder.manufacturer());
    }
}