package com.example.translator;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.translator.spi.Dictionary;
import com.example.translator.spi.DictionaryFactory;
import com.example.translator.types.DictionaryNotAvailable;
import com.example.translator.types.TQuoteStatus;
import com.example.translator.types.TextNotTranslatable;

public class TextTranslator_Impl implements TextTranslator, Remote {
  
  private static Set clientNames = new HashSet();
  
  private static final Log log = LogFactory.getLog(TextTranslator_Impl.class);

  public String translate(String text, String sourceLanguage, String targetLanguage)
      throws DictionaryNotAvailable, TextNotTranslatable, RemoteException {
    Locale sourceLocale = new Locale(sourceLanguage);
    Locale targetLocale = new Locale(targetLanguage);
    DictionaryFactory dictionaryFactory = DictionaryFactory.getInstance(sourceLocale, targetLocale);
    Dictionary dictionary = dictionaryFactory.createDictionary(sourceLocale, targetLocale);
    return dictionary.translate(text);
  }

  public void quoteTranslation(String clientName, String text, 
      String sourceLanguage, String targetLanguage) throws RemoteException {
    log.debug("received quotation request: clientName=" + clientName);
    clientNames.add(clientName);
  }
  
  public TQuoteStatus getQuotationStatus(String clientName) throws RemoteException {
    TQuoteStatus quoteStatus = clientNames.contains(clientName) ?
        TQuoteStatus.received : TQuoteStatus.none;
    return quoteStatus;
  }
}
