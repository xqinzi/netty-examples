package com.ustcinfo.rpc;

import com.ustcinfo.rpc.protocol.Decoder;
import com.ustcinfo.rpc.protocol.Encoder;
import com.ustcinfo.rpc.protocol.JavaDecoder;
import com.ustcinfo.rpc.protocol.JavaEncoder;

public class Codecs {
	
	public static final int JAVA_CODEC = 1;
	
	public static final int HESSIAN_CODEC = 2;
	
	public static final int PB_CODEC = 3;
	
	public static final int KRYO_CODEC = 4;
	
	private static Encoder[] encoders = new Encoder[5];
	
	private static Decoder[] decoders = new Decoder[5];
	
	static{
		addEncoder(JAVA_CODEC, new JavaEncoder());
		
		addDecoder(JAVA_CODEC, new JavaDecoder());
	}
	
	public static void addEncoder(int encoderKey,Encoder encoder){
		if(encoderKey > encoders.length){
			Encoder[] newEncoders = new Encoder[encoderKey + 1];
			System.arraycopy(encoders, 0, newEncoders, 0, encoders.length);
			encoders = newEncoders;
		}
		encoders[encoderKey] = encoder;
	}
	
	public static void addDecoder(int decoderKey,Decoder decoder){
		if(decoderKey > decoders.length){
			Decoder[] newDecoders = new Decoder[decoderKey + 1];
			System.arraycopy(decoders, 0, newDecoders, 0, decoders.length);
			decoders = newDecoders;
		}
		decoders[decoderKey] = decoder;
	}
	
	public static Encoder getEncoder(int encoderKey){
		return encoders[encoderKey];
	}
	
	public static Decoder getDecoder(int decoderKey){
		return decoders[decoderKey];
	}
	
}
