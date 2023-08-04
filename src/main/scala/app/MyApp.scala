package app

// Internal package
import pkg.db.Db

import zio._
import zhttp.http._
import zhttp.service.Server

object MyApp extends ZIOAppDefault:
  // Create HTTP route
  private def appHttp(): Http[Any, Nothing, Request, Response] =
    Http.collect[Request] {
      case req@(Method.GET -> !! / "greet") if (req.url.queryParams.nonEmpty) =>
        Response.text(s"Hello ${req.url.queryParams("name").mkString(" and ")}!")

      case Method.GET -> !! / "greet" =>
        Response.text(s"Hello World!")

      case Method.GET -> !! / "greet" / name =>
        Response.text(s"Hello $name!")
    }

  override val run: ZIO[Any, Throwable, Nothing] =
    Server.start(
      port = 8080,
      http = appHttp()
    )