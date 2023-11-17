package me.blvckbytes.springcommon.exception

abstract class DescribedException : RuntimeException() {

  abstract fun getDescription(): String

}