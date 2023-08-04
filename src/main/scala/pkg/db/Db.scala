package pkg.db

import zio._
import zio.jdbc._

object Db:
  def mysqlConnect(): ZLayer[ZConnectionPoolConfig, Throwable, ZConnectionPool] =
    val createZIOPoolConfig: ULayer[ZConnectionPoolConfig] =
      ZLayer.succeed(ZConnectionPoolConfig.default)

    val properties = Map(
      "user" -> "root",
      "password" -> "123456"
    )

    val connectionPool: ZLayer[ZConnectionPoolConfig, Throwable, ZConnectionPool] =
      ZConnectionPool.mysql("localhost", 3306, "maji_kurafuto_mysql", properties)

    connectionPool
