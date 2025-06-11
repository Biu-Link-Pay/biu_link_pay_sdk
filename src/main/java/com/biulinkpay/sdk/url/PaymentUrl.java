package com.biulinkpay.sdk.url;

public interface PaymentUrl {

    String domain = "https://api.biulinkpay.online";

    String queryUrl = "/api/pay/merchant/paymentQuery";

    String buyOrderUrl = "/api/pay/merchant/buyOrder";

    String sellOrderUrl = "/api/pay/merchant/sellOrder";

    String paymentMethod = "/api/pay/merchant/paymentMethods";

    String rateQueryUrl = "/api/pay/common/rateQuery";

}