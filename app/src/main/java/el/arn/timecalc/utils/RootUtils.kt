package el.arn.timecalc.utils

import android.app.Application
import el.arn.timecalc.calculation_engine.TimeConverter
import el.arn.timecalc.calculation_engine.TimeConverterImpl
import el.arn.timecalc.calculation_engine.TimeExpressionFactory
import el.arn.timecalc.utils.config.ConfigManager
import el.arn.timecalc.utils.config.ConfigManagerImpl

interface RootUtils {
    val timeConverter: TimeConverter
    val toastManager: ToastManager
    val configManager: ConfigManager
    val timeExpressionFactory: TimeExpressionFactory
}

class RootUtilsImpl(app: Application) : RootUtils {
    override val timeConverter: TimeConverter = TimeConverterImpl()
    override val toastManager: ToastManager = ToastManagerImpl(app.applicationContext)
    override val configManager: ConfigManager = ConfigManagerImpl()
    override val timeExpressionFactory = TimeExpressionFactory(configManager.getTimeExpressionConfig())

}