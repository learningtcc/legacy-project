package java.util;

class CurrencyData {

    static final String mainTable = "\u007f\u007f\u007f\u0081CM\u0082\u007f\u0082\u007f\u007fKCF@\u007f\u0080R\u0083\u0081C\u007fF\u0081\u007fL" +
                                    "LC\u007fS\u0081\u0084Mc\u0005\u0084\u007f\u007fCCA\u007f\u007fKCM\u007f\u0085O\u007f\u0011C" +
                                    "C\u007f\u0086E\u007f\u0087\u0087E\u0084\u007f\u0088\u000f\u0087XO\u007f\u007fBC\u007fOD\u007f\u0086OJ" +
                                    "\u007f\u007f\u007f\u007f\u0081\u007f\u007f\u007f\u007f\u0005J\u007f\u0082\u007fO\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fC" +
                                    "\u007f\u007f\u0083\u007fJ\u007fO\u0089\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fM\u0081A\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u0081CO\u007f\u0083\u007f\u008a\u007f\u007f\u0081\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u0087O\u007f\u0082K\u0081\u007fBO\u007f\u007f\u008aC\u0005\u007f\u0081\u0087\u0081\u008bP\u0083\u007f\u0084\u007fC\u007f" +
                                    "\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fC\u007f\u0086K\u007f\u007f\u007fJ\u007fFE\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007fQ\u0081\u007f\u007f\u007f\u007f\u007f\u007fR\u007fQ\u0083\u007fcQJ\u0081\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fC\u007fc\u0018\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007fR\u007fRQ\u0086\u007f\u007f\u007f\u0005\u0082\u007fV\u007f\u0016\u007f\u007f\u007f\u007fc\u007fCS" +
                                    "JO\u0082\u007f\u007f\u007f\u007f\u007f\u008c\u007fQ\u007f\u007f\u007f\u007f\u007f\u007fCKK\u0081K\u007f\u007fc\u007f" +
                                    "C\u007f\u0081K\u007f\u007f\u0005\u0083\u007f\u007fC\u0084JSO\u0083\u0081N\u0082KQQJMQL" +
                                    "C\u007f\u008d\u007f\u0084\u0086M\u007fN\u007f\u007f\u0081\u007f\u007fJQ\u007f\u0086\u007f\u007f\u0088\u007f\u007f\u007f\u007fC" +
                                    "\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fq\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "A\u007f\u007f\u007fM\u008dJO\u007f\u007fQM\u0081\u0088\u007f\u007f\u007f\u0083\u008e\u0081\u007f\u007f\u0083\u007f\u0006\u007f" +
                                    "Q\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007f\u0081\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fK\u007f\u007f\u007f\u007f\u007fA\u007f\u0005\u007f\u007f\u007f" +
                                    "QCQCJ\u007fCOS\u0085JK\u0081\u0084R\u007f\u007fC\u007fC\u007fB\u007f\u007fOK" +
                                    "\u007f\u007f\u0083\u0087\u007f\u0081\u0084A\u007fR\u0088\u0083LcO\u007f\u007f\u000b\u007fC\u007f\u0086C\u007f\u007fR" +
                                    "G\u007f\u007f\u007f\u007f\u007fW\u007f\u007f\u007f\u007f\u007f\u0083\u007f\u007f\u007f\u007f\u007fC\u007f\u007f\u007f\u007f\u007fTR" +
                                    "\u0081\u007f\u0082\u007fA\u007f\u0083\u007f\u0083\u007f\u007f\u007f\u007fC\u007f\u007f\u007f\u007f\u007f\u007f\u0015\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007f\u007f\u008d\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fS\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "\u007f\u007f\u007f\u007fQ\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u0081\u007f\u007f\u007f\u007f\u007f\u007f" +
                                    "Q\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fJ\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007f\u007fC\u007f\u007f\u007f";

    static final long[] scCutOverTimes = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, };

    static final String[] scOldCurrencies = { "EUR", "XCD", "USD", "XOF", "NOK", "AUD", "XAF", "NZD", "MAD", "DKK", "GBP", "CHF", "XPF", "ILS", };

    static final String[] scNewCurrencies = { null, null, null, null, null, null, null, null, null, null, null, null, null, null, };

    static final int[] scOldCurrenciesDFD = { 2, 2, 2, 0, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, };

    static final int[] scNewCurrenciesDFD = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };

    static final String otherCurrencies = "ADP-AFA-ATS-BEF-BGL-BOV-BYB-CLF-DEM-ESP-EUR-FIM-FRF-GRD-GWP-IEP-ITL-LUF-MXV-NLG-PTE-RUR-SRG-TPE-USN-USS-XAF-XAG-XAU-XBA-XBB-XBC-XBD-XCD-XDR-XFO-XFU-XOF-XPD-XPF-XPT-XTS-XXX-YUM";

    static final int[] otherCurrenciesDFD = { 0, 2, 2, 0, 2, 2, 0, 0, 2, 0, 2, 2, 2, 0, 2, 2, 0, 0, 2, 2, 0, 2, 2, 0, 2, 2, 0, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, 0, -1, 0, -1, -1, -1, 2, };

}

