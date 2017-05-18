call cd out/production/LifeLogger
call jar cvfe client.jar lifelogger.client.Main lifelogger\client lifelogger\recorder lifelogger\data lifelogger\server META-INF
call java -jar client.jar