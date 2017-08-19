package Uniwork.Misc;

import Uniwork.Base.NGObjectRequestMethod;
import Uniwork.Base.NGObjectRequestParameter;
import Uniwork.Base.NGObjectRequestRegistration;
import Uniwork.Script.NGCustomScriptFunctions;

public class NGConsoleScriptFunctions extends NGCustomScriptFunctions {

    public static String CConsole = "Console";

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        registerObjectRequest("EchoOn", "ConsoleEchoOn");
        registerObjectRequest("EchoOff", "ConsoleEchoOff");
        registerObjectRequest("ShowVariables", "ConsoleShowVariables");
        NGObjectRequestMethod orm = registerObjectRequest( "RunScript", "RunScript");
        orm.addParam("Script", NGObjectRequestParameter.ParamKind.String);
    }

    public NGConsoleScriptFunctions(NGObjectRequestRegistration aORR, Object aDelegate) {
        super(aORR, aDelegate);
        FDomain = CConsole;
    }

}