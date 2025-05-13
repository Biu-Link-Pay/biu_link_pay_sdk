package com.biulinkpay.sdk.url;

public interface PaymentUrl {

    String domain = "https://api.biulinkpay.online";

    String queryUrl = "/api/pay/merchant/paymentQuery";

    String insertUrl = "/api/pay/merchant/createOrder";

    String paymentMethod = "/api/pay/merchant/paymentMethods";

    String rateQueryUrl = "/api/pay/common/rateQuery";

}