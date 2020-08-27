import axios from 'axios';

export const createPurchase = async ( purchase ) => {
    try {
      const data = await axios.post('http://localhost:8080/event-microservice/createPurchase', { purchase });
      return { data, error: null };
    } catch (error) {
      return { data: null, error };
    }
  };
  
  export const getPurchases = async () => {
    try {
      const response = await axios.get('http://localhost:8080/event-microservice/getPurchases');
      //console.log('Aqui es ', response.data);
      return { data: response.data, error: null };
    } catch (error) {
      return { data: null, error: error.response };
    }
  };
