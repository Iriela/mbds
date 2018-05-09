/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author iriel
 */
public class Constants {
    public static String _FR = "FR";
    public static String _EN = "EN";
    
    public static String _QUERYFORUSERS = "SELECT MAX(u.iduser) FROM Users u";
    public static String _QUERYFORWORD = "SELECT MAX(w.idword) FROM Word w";
    public static String _QUERYFORTEST = "SELECT MAX(t.idtest) FROM Test t";
    public static String _QUERYFORTESTRESULT = "SELECT MAX(t.idtestresult) FROM Testresult t";
    public static String _QUERYFORLIST = "SELECT MAX(l.idlist) FROM List l";
}
