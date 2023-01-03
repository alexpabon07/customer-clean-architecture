package co.com.bancolombia.mongo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class DetailCustomerEntity {
    private String paymentFormat;
    private String paymentApplication;
    private String affectsLotCrediPago;
    private String noBankOperator;
    private String commissionChargeScheme;
    private String commissionDebitForm;
    private String comissionTime;
    private String pensionsPayingEntity;
    private String noveltyPayrollAccount;
    private String schemePaymentReport;
    private String generateCheque;
    private String cashPayments;
    private String formatModality;
    private String versionTyC;
}
