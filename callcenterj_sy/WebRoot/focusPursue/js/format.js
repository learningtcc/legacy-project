/*-------------------------------------------------------------------------------*
 * ????????????????????????????????????????????????????????????????????????
 * ??HTML??????????????????????????????,????????????????DIVText??????,??????????
 * <script language="JavaScript" src="mypath/DIVText/js/format.js">
 * Design By Firefox 2006??1?? mcw@chsegang.com.cn MSN: lcsoft@public.ytptt.sd.cn
 * HomePage: http://firefox.ourspower.com/
 *------------------------------------------------------------------------------*/
//????????
var abspath="/callcenterj_sy/images/wededitor/";

//????????????????SPan??ID
var maindiv="divtext";
var mainspan="fimg";
var footspan="fspan";

//??????????????ID
var Paragraphid="div_paragraph";
var ftNameid="div_ftname";
var ftSizeid="div_ftsize";
var fgColorid="div_fgcolor";
var frColorid="div_frcolor";
var Smileid="div_smile";
var Pictureid="div_picture";
var editTextid="txt_edittext";



//????????????????????
document.onclick=docclick;

//1??????????????????
document.write("<span id='"+mainspan+"'></span>");
createFormatSpan(document.getElementById(mainspan));

//2????????????????
document.write("<div id='"+maindiv+"'></div>");
createMainDiv(document.getElementById(maindiv));

//3??????????
document.write("<div id='"+footspan+"'></div>");
createFootSpan(document.getElementById(footspan));

//4????????????????????
createParaDiv(Paragraphid);
createFontnameDiv(ftNameid);
createFontsizeDiv(ftSizeid);
createColorDiv(fgColorid);
createColorDiv(frColorid);
createSmileDiv(Smileid);
createPictureDiv(Pictureid);
createEditText(editTextid);