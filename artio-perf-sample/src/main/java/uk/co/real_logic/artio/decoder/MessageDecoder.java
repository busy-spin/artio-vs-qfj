/* Generated Fix Gateway message codec */
package uk.co.real_logic.artio.decoder;

import uk.co.real_logic.artio.builder.Decoder;
import uk.co.real_logic.artio.dictionary.Generated;

@Generated("uk.co.real_logic.artio")
public interface MessageDecoder extends Decoder
{
    HeaderDecoder header();

    TrailerDecoder trailer();
}