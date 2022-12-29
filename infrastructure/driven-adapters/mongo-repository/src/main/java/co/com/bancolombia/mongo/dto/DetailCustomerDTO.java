package co.com.bancolombia.mongo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder(toBuilder = true)
public class DetailCustomerDTO {
    private String paymentFormat;
    private String paymentApplication;
    private String affectsLotCreditPago;
    private String noBankOperator;
    private String commissionChargeScheme;
    private String commissionDebitForm;
    @Field("comissionTime")
    private String commissionTime;
    private String pensionsPayingEntity;
    private String noveltyPayrollReport;
    private String schemePayrollAccount;
    private String generateCheque;
    private String cashPayments;
    private String formatModality;
    private String versionTyC;
}
