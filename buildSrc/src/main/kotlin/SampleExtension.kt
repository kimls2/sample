import org.gradle.api.Project

open class SampleExtension(
    val project: Project
) {
    var appName: String? = null
    var applicationId: String? = null
}