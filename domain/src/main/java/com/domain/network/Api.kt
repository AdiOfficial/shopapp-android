package com.domain.network

import com.apicore.ApiCallback
import com.domain.entity.*

interface Api {

    fun getProductList(perPage: Int, paginationValue: Any? = null, sortBy: SortType? = null,
                       reverse: Boolean = false, callback: ApiCallback<List<Product>>)

    fun searchProductList(perPage: Int, paginationValue: Any? = null, searchQuery: String,
                          callback: ApiCallback<List<Product>>)

    fun getProduct(id: String, callback: ApiCallback<Product>)

    fun getCategoryList(perPage: Int, paginationValue: Any?, sortBy: SortType? = null,
                        reverse: Boolean = false, callback: ApiCallback<List<Category>>)

    fun getCategoryDetails(id: String, perPage: Int, paginationValue: Any?, sortBy: SortType? = null,
                           reverse: Boolean = false, callback: ApiCallback<Category>)

    fun getShopInfo(callback: ApiCallback<Shop>)

    fun getArticleList(perPage: Int, paginationValue: Any?, sortBy: SortType? = null,
                       reverse: Boolean = false, callback: ApiCallback<List<Article>>)

    fun signUp(firstName: String, lastName: String, email: String, password: String, callback: ApiCallback<Customer>)

    fun signIn(email: String, password: String, callback: ApiCallback<Customer>)

    fun isLoggedIn(callback: ApiCallback<Boolean>)

    fun getCustomer(callback: ApiCallback<Customer>)

    fun createCheckout(cartProductList: List<CartProduct>)
}