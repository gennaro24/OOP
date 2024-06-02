public class CodeCheckerEN implements CodeChecker{
    @Override
    public boolean check(String codice) {
        return codice.matches("^EN[0-9]{2}[A-Za-z]{2}$");
    }
}
