import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.ttbdlk.DAOImplementation;

public class test{
    @ParameterizedTest
    @CsvFileSource(resources = "teamName.csv", numLinesToSkip = 1)
    void teamNameIsValidTest(String teamName, boolean expected){
        DAOImplementation DAOi=new DAOImplementation();
        boolean result= DAOi.teamNameIsValid(teamName);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "division.csv", numLinesToSkip = 1)
    void divisionIsValidTest(String division, boolean expected){
        DAOImplementation DAOi=new DAOImplementation();
        boolean result= DAOi.divisionIsValid(division);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "ownerName.csv", numLinesToSkip = 1)
    void ownerNameIsValidTest(String ownerName, boolean expected){
        DAOImplementation DAOi=new DAOImplementation();
        boolean result= DAOi.ownerNameIsValid(ownerName);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "coachName.csv", numLinesToSkip = 1)
    void coachNameIsValidTest(String coachName, boolean expected){
        DAOImplementation DAOi=new DAOImplementation();
        boolean result= DAOi.coachNameIsValid(coachName);
        Assertions.assertEquals(expected, result);
    }
}
