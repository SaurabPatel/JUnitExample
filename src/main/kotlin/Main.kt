fun main(args: Array<String>) {
    println("Enter ScreenName: ")
    var input = readLine()

    val android = Android(screenName = input!!)
    val flutter = Flutter(screenName = input)
    val iOS     = IOS(screenName = input)

    println("\nAndroid Screen Names")
    println("layout name     : ${android.layoutName()}")
    println("controller name : ${android.controllerName()}")
    println("model Name      : ${android.modelName()}")

    println("\nFlutter Screen Names")
    println("layout name     : ${flutter.layoutName()}")
    println("controller name : ${flutter.controllerName()}")
    println("model Name      : ${flutter.modelName()}")

    println("\nIOS Screen Name")
    println("view name       : ${iOS.controllerName()}")
    println("viewModel name  : ${iOS.modelName()}")
}