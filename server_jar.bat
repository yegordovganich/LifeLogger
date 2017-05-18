call cd out/production/LifeLogger
call jar cvfe server.jar lifelogger.server.LifeLoggerServer lifelogger\server lifelogger\recorder lifelogger\data
call java -jar server.jar