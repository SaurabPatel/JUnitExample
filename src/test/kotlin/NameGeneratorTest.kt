import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NameGeneratorTest {

    @Test
    fun controllerName() {
        val controllerName = Android(screenName = "123Test\$%").controllerName()
        assertEquals("TestActivity", controllerName, "Controller Name is generated wrong.")
    }

    @Test
    fun layoutName() {
        val screenName = "123\$%"
        val controllerName = IOS(screenName = screenName).controllerName()
        assertNull(controllerName, "${screenName} generated name is ${controllerName}")
    }

    @Test
    fun modelName() {
        val controllerName = IOS(screenName = "@#test").modelName()
        assertTrue(controllerName is String)
    }
}