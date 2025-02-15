import com.anasbinrashid.i220907.R
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anasbinrashid.i220907.EditProfileActivity
import com.anasbinrashid.i220907.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {
    @JvmField
    @Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testDoneButtonNavigation()
    {
        Espresso.onView(withId(R.id.loginbutton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("My Community")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}