import com.anasbinrashid.i220907.R
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anasbinrashid.i220907.EditProfileActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EditProfileTest {
    @JvmField
    @Rule
    var activityRule: ActivityScenarioRule<EditProfileActivity> = ActivityScenarioRule(EditProfileActivity::class.java)

    @Test
    fun testDoneButtonNavigation()
    {
        Espresso.onView(withId(R.id.done)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("My Profile")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}