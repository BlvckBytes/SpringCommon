package me.blvckbytes.springcommon.validation

interface ComparisonFunction {

  fun <T : Comparable<T>> apply(a: T, b: T): Boolean

}