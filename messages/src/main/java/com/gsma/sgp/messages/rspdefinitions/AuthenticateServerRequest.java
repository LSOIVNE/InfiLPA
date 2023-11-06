/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;

import com.gsma.sgp.messages.pkix1explicit88.Certificate;
import com.gsma.sgp.messages.pkix1explicit88.CertificateList;
import com.gsma.sgp.messages.pkix1explicit88.Time;
import com.gsma.sgp.messages.pkix1implicit88.SubjectKeyIdentifier;

public class AuthenticateServerRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 56);

	public byte[] code = null;
	private ServerSigned1 serverSigned1 = null;
	private BerOctetString serverSignature1 = null;
	private SubjectKeyIdentifier euiccCiPKIdToBeUsed = null;
	private Certificate serverCertificate = null;
	private CtxParams1 ctxParams1 = null;
	
	public AuthenticateServerRequest() {
	}

	public AuthenticateServerRequest(byte[] code) {
		this.code = code;
	}

	public void setServerSigned1(ServerSigned1 serverSigned1) {
		this.serverSigned1 = serverSigned1;
	}

	public ServerSigned1 getServerSigned1() {
		return serverSigned1;
	}

	public void setServerSignature1(BerOctetString serverSignature1) {
		this.serverSignature1 = serverSignature1;
	}

	public BerOctetString getServerSignature1() {
		return serverSignature1;
	}

	public void setEuiccCiPKIdToBeUsed(SubjectKeyIdentifier euiccCiPKIdToBeUsed) {
		this.euiccCiPKIdToBeUsed = euiccCiPKIdToBeUsed;
	}

	public SubjectKeyIdentifier getEuiccCiPKIdToBeUsed() {
		return euiccCiPKIdToBeUsed;
	}

	public void setServerCertificate(Certificate serverCertificate) {
		this.serverCertificate = serverCertificate;
	}

	public Certificate getServerCertificate() {
		return serverCertificate;
	}

	public void setCtxParams1(CtxParams1 ctxParams1) {
		this.ctxParams1 = ctxParams1;
	}

	public CtxParams1 getCtxParams1() {
		return ctxParams1;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += ctxParams1.encode(reverseOS);
		
		codeLength += serverCertificate.encode(reverseOS, true);
		
		codeLength += euiccCiPKIdToBeUsed.encode(reverseOS, true);
		
		codeLength += serverSignature1.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;
		
		codeLength += serverSigned1.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(ServerSigned1.tag)) {
			serverSigned1 = new ServerSigned1();
			subCodeLength += serverSigned1.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			serverSignature1 = new BerOctetString();
			subCodeLength += serverSignature1.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(SubjectKeyIdentifier.tag)) {
			euiccCiPKIdToBeUsed = new SubjectKeyIdentifier();
			subCodeLength += euiccCiPKIdToBeUsed.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(Certificate.tag)) {
			serverCertificate = new Certificate();
			subCodeLength += serverCertificate.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		ctxParams1 = new CtxParams1();
		subCodeLength += ctxParams1.decode(is, berTag);
		if (subCodeLength == totalLength) {
			return codeLength;
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSigned1 != null) {
			sb.append("serverSigned1: ");
			serverSigned1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverSigned1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSignature1 != null) {
			sb.append("serverSignature1: ").append(serverSignature1);
		}
		else {
			sb.append("serverSignature1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccCiPKIdToBeUsed != null) {
			sb.append("euiccCiPKIdToBeUsed: ").append(euiccCiPKIdToBeUsed);
		}
		else {
			sb.append("euiccCiPKIdToBeUsed: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverCertificate != null) {
			sb.append("serverCertificate: ");
			serverCertificate.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverCertificate: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (ctxParams1 != null) {
			sb.append("ctxParams1: ");
			ctxParams1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("ctxParams1: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

