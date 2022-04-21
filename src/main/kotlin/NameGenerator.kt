abstract class NameGenerator(open val screenName: String) {

    open var regex = "[^a-zA-Z ]".toRegex()

    protected fun cleanName(): String? {
        //Remove all special character and numbers
        val cleanName = screenName.replace(regex, "")
        //Check string is empty ot not
        return cleanName.ifBlank { null }
    }

    abstract fun controllerName(): String?

    abstract fun layoutName(): String?

    abstract fun modelName(): String?
}

class Android(override val screenName: String): NameGenerator(screenName) {

    override fun controllerName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "")
        return if(name != null) "${name}Activity" else { null }
    }

    override fun layoutName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "_")
        name = name?.lowercase()
        return if(name != null) "activity_$name" else { null }
    }

    override fun modelName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "")
        return if(name != null) "${name}Model" else { null }
    }
}

class Flutter(screenName: String): NameGenerator(screenName) {
    override fun controllerName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "_")
        name = name?.lowercase()
        return if(name != null) "${name}_controller" else { null }
    }

    override fun layoutName(): String?  {
        var name = super.cleanName()
        name = name?.replace(" ", "_")
        name = name?.lowercase()
        return if(name != null) "$name" else { null }
    }

    override fun modelName(): String?  {
        var name = super.cleanName()
        name = name?.replace(" ", "_")
        name = name?.lowercase()
        return if(name != null) "${name}_model" else { null }
    }
}

class IOS(screenName: String): NameGenerator(screenName) {
    override fun controllerName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "")
        return if(name != null) "${name}View" else { null }
    }

    override fun layoutName(): String? {
        return null
    }

    override fun modelName(): String? {
        var name = super.cleanName()
        name = name?.replace(" ", "")
        return if(name != null) "${name}ViewModel" else { null }
    }
}