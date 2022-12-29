package co.com.bancolombia.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class DetailCustomerDTO {
    private String paymentFormat;
    private String paymentApplication;
    private String affectsLotCreditPago;
    private String noBankOperator;
    private String commissionChargeScheme;
    private String commissionDebitForm;
    private String commissionTime;
    private String pensionsPayingEntity;
    private String noveltyPayrollReport;
    private String schemePayrollAccount;
    private String generateCheque;
    private String cashPayments;
    private String formatModality;
    private String versionTyC;
}
