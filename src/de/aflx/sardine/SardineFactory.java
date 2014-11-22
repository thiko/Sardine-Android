package de.aflx.sardine;

import de.aflx.sardine.impl.SardineImpl;

import java.io.IOException;
import java.net.ProxySelector;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * The perfect name for a class. Provides the static methods for working with the Sardine interface.
 *
 * @author jonstevens
 * @version $Id: SardineFactory.java 243 2011-05-24 20:50:34Z dkocher@sudo.ch $
 */
public class SardineFactory
{
	/**
	 * Default begin() for when you don't need anything but no authentication
	 * and default settings for SSL.
	 * @throws UnrecoverableKeyException 
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 * @throws CertificateException 
	 */
	public static Sardine begin() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
	{
		return begin(null, null);
	}

	/**
	 * Pass in a HTTP Auth username/password for being used with all
	 * connections
	 *
	 * @param username Use in authentication header credentials
	 * @param password Use in authentication header credentials
	 * @throws UnrecoverableKeyException 
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 * @throws CertificateException 
	 */
	public static Sardine begin(String username, String password) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
	{
		return begin(username, password, null, true);
	}

	/**
	 * @param username Use in authentication header credentials
	 * @param password Use in authentication header credentials
	 * @param proxy	Proxy configuration
	 * @param withCertificationCheck  Use this parameter to control, if the given certification should be checked or not. Useful for self-signed certificates!
	 * @throws UnrecoverableKeyException 
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 * @throws CertificateException 
	 */
	public static Sardine begin(String username, String password, ProxySelector proxy, boolean withCertificationCheck) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
	{
		return new SardineImpl(username, password, proxy, withCertificationCheck);
	}
}