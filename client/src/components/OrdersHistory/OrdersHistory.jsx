import React from "react";
import Table from "../Table/Table";
import { getPurchases } from "../../Api/evento";

const OrdersHistory = () => {
  const fields = ["user", "event", "amount", "trasanctionFee"];

  const head = { user: "Usuario", event: "Evento", amount: "Monto", trasanctionFee: "Costo de transacción" };

  const [data, setData] = React.useState([]);

  React.useEffect( () => {
    const get = async () => {
      const purchases = await getPurchases();
      const newData = purchases.data.map( purchase =>
        createData(purchase.user, purchase.event, purchase.amount, purchase.transactionFee)
      );
      setData(newData);
    }
    get();
  }, []);

  // Generate Order Data
  function createData(id, date, products, status, amount) {
    return { id, date, products, status, amount };
  }

  return <Table title="Historial de ordenes" fields={fields} head={head} data={data} />;
};

export default OrdersHistory;
