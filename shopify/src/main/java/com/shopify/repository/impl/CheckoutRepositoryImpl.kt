package com.shopify.repository.impl

import com.domain.entity.Address
import com.domain.entity.Card
import com.domain.entity.CartProduct
import com.google.android.gms.wallet.FullWallet
import com.data.rx.RxCallback
import com.shopify.api.ShopifyApi
import com.shopify.buy3.pay.PayCart
import com.shopify.entity.Checkout
import com.shopify.entity.ShippingRate
import com.shopify.repository.CheckoutRepository
import io.reactivex.Single

class CheckoutRepositoryImpl(private val api: ShopifyApi) : CheckoutRepository {

    override fun createCheckout(cartProductList: List<CartProduct>): Single<Checkout> {
        return Single.create<Checkout> {
            api.createCheckout(cartProductList, RxCallback<Checkout>(it))
        }
    }

    override fun getShippingRates(checkoutId: String, email: String, address: Address): Single<List<ShippingRate>> {
        return Single.create<List<ShippingRate>> {
            api.getShippingRates(checkoutId, email, address, RxCallback<List<ShippingRate>>(it))
        }
    }

    override fun selectShippingRate(checkoutId: String, shippingRate: ShippingRate): Single<Checkout> {
        return Single.create<Checkout> {
            api.selectShippingRate(checkoutId, shippingRate, RxCallback<Checkout>(it))
        }
    }

    override fun payByCard(card: Card): Single<String> {
        return Single.create<String> {
            api.payByCard(card, RxCallback<String>(it))
        }
    }

    override fun completeCheckoutByCard(checkout: Checkout, address: Address, creditCardVaultToken: String): Single<Boolean> {
        return Single.create<Boolean> {
            api.completeCheckoutByCard(checkout, address, creditCardVaultToken, RxCallback<Boolean>(it))
        }
    }

    override fun createPayCart(checkout: Checkout, cartProductList: List<CartProduct>): Single<PayCart> {
        return Single.create<PayCart> {
            api.createAndroidPayCart(checkout, cartProductList, RxCallback<PayCart>(it))
        }
    }

    override fun completeCheckoutByAndroidPay(checkout: Checkout, payCart: PayCart,
                                              fullWallet: FullWallet): Single<Boolean> {
        return Single.create<Boolean> {
            api.completeCheckoutByAndroid(checkout, payCart, fullWallet, RxCallback<Boolean>(it))
        }
    }
}