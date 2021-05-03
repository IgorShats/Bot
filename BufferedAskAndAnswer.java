import java.util.HashMap;

public class BufferedAskAndAnswer {
    static HashMap<String, Object> EKF;
    static HashMap<String, Object> FTRandR;
    static HashMap<String, Object> FGandGF;
    static HashMap<String, Object> GRF;
    static HashMap<String, Object> GGF;
    static HashMap<String, Object> FEandU;

    BufferedAskAndAnswer() throws Exception {
        AskAndAnswer askAndAnswer1 = new AskAndAnswer();
        EKF = askAndAnswer1.initializer("ЭКФ");
        AskAndAnswer askAndAnswer2 = new AskAndAnswer();
        FTRandR = askAndAnswer2.initializer("ФТРиР");
        AskAndAnswer askAndAnswer3 = new AskAndAnswer();
        GRF = askAndAnswer3.initializer("ГРФ");
        AskAndAnswer askAndAnswer4 = new AskAndAnswer();
        GGF = askAndAnswer4.initializer("ГГФ");
        AskAndAnswer askAndAnswer5 = new AskAndAnswer();
        FEandU = askAndAnswer5.initializer("ФЭиУ");
        AskAndAnswer askAndAnswer6 = new AskAndAnswer();
        FGandGF = askAndAnswer6.initializer("ФГиГФ");
    }
}
