import logo from './logo.svg';
import './App.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <div className="app-wrapper">
        <Form>
        <Form.Group className="mb-3" controlId="formIncome">
          <Form.Label>Gross Monthly Income</Form.Label>
          <Form.Control type="text" placeholder="Gross monthly income" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formCar">
          <Form.Label>Monthly Car Payment</Form.Label>
          <Form.Control type="text" placeholder="Monthly car payment" />
        </Form.Group>
        
        <Form.Group className="mb-3" controlId="formStudent">
          <Form.Label>Student Loan Payment</Form.Label>
          <Form.Control type="text" placeholder="Student loan payment" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formCreditScore">
          <Form.Label>Credit Score</Form.Label>
          <Form.Control type="text" placeholder="Credit score" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formCreditCard">
          <Form.Label>Monthly Credit Car Payment</Form.Label>
          <Form.Control type="text" placeholder="Monthly credit card payment" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formHomeValue">
          <Form.Label>Home Appraised Value</Form.Label>
          <Form.Control type="text" placeholder="Home appraised value" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formDownPayment">
          <Form.Label>Down Payment Amount</Form.Label>
          <Form.Control type="text" placeholder="Down payment amount" />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
      </div>
    </div>
  );
}

export default App;
