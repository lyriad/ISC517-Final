import React from "react";
import { PayPalButton } from "react-paypal-button-v2";
import { createPurchase } from "../../Api/evento";

const PayButton = ({ amount }) => {
  return (
    <PayPalButton
      amount={amount}
      onSuccess={ async (details, data) => {
        await createPurchase(
          {
            user: 'admin@admin.com',
            event: 'Cumpleaño',
            amount: details.purchase_units[0].amount.value,
            transactionFee: 0.3,
          }
        );
        // window.location = '/historial-compras'
        alert("Transaction completed by " + details.payer.name.given_name);
      }}
      options={{
        clientId: "AdPyWLQa2hziR70RmnTiacG8OPzy8kRiQbsQNF0iZSPGf6Lh5e-lqFzjvLeQZHWDrwj6uCcOVoG52jZw",
      }}
    />
  );
};

export default PayButton;
