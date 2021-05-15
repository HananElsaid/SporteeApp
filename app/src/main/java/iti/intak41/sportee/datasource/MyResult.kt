/*
package iti.intak41.sportee.datasource

data class MyResult <out T>(val status: Status, val data: T?, val message: String?) {


    companion object {
        fun <T> success(data: T?): MyResult<T> {
            return MyResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): MyResult<T> {
            return MyResult(Status.ERROR,msg)
        }

        fun <T> loading(data: T?): MyResult<T> {
            return MyResult(Status.LOADING, data, null)
        }

    }

}*/
