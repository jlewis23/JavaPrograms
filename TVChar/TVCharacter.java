/**
 * Class: Advanced Programming
 * 
 * @author Jeremy Lewis
 * @version 1.0 Course : ITEC 3150 Spring 2014 Written: February 25, 2014
 * 
 *          Person class that creates the variables to allow reading in the
 *          TwentyPeople.txt And sets hashCode and Equals methods for
 *          PersonTester
 */

public class TVCharacter
{
    // This person should have a FirstName, lastName, birthDate, age, and tvShow
    String firstName;
    String lastName;
    String birthDate;
    String charAge;
    String tvShow;

    // Person method creates the listed variables
    public TVCharacter(String firstName, String lastName, String birthDate,
            String charAge, String tvShow)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.charAge = charAge;
        this.tvShow = tvShow;
    }

    // get FirstName method
    public String getFirstName()
    {
        return firstName;
    }

    // Set firstName Method
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // get LastName method
    public String getLastName()
    {
        return lastName;
    }

    // set LastName method
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // get birthDate Method
    public String getBirthDate()
    {
        return birthDate;
    }

    // set birthDate Method
    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    // get charAge method
    public String getCharAge()
    {
        return charAge;
    }

    // set charAge method
    public void setCharAge(String charAge)
    {
        this.charAge = charAge;
    }

    // get TVShow method
    public String getTVShow()
    {
        return tvShow;
    }

    // set tvShow method
    public void setTVShow(String tvShow)
    {
        this.tvShow = tvShow;
    }

    // Method for adding data to Table for TVCharacter data entry
    public String[] getTableValues()
    {
        String[] myRowInfo = new String[5];
        myRowInfo[0] = firstName;
        myRowInfo[1] = lastName;
        myRowInfo[2] = birthDate;
        myRowInfo[3] = charAge;
        myRowInfo[4] = tvShow;
        return myRowInfo;
    }
}