import { useState } from "react";
import axios from "axios";

function App() {
  const [hourlyRate, setHourlyRate] = useState("");
  const [hoursWorked, setHoursWorked] = useState("");
  const [pension, setPension] = useState("");
  const [otherDeductions, setOtherDeductions] = useState("");
  const [result, setResult] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/salary/calculate",
        {
          hourlyRate: parseFloat(hourlyRate),
          hoursWorked: parseFloat(hoursWorked),
          pensionPercentage: pension ? parseFloat(pension) : undefined,
          otherDeductions: otherDeductions
            ? parseFloat(otherDeductions)
            : undefined,
        }
      );
      setResult(response.data);
    } catch (err) {
      alert("Error calculating salary. Make sure backend is running.");
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
      <div className="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
        <h1 className="text-2xl font-bold mb-6 text-center">
          Salary Calculator
        </h1>
        <form className="space-y-4" onSubmit={handleSubmit}>
          <div>
            <label className="block text-gray-700 mb-1">
              Hourly Rate (DKK):
            </label>
            <input
              type="number"
              value={hourlyRate}
              onChange={(e) => setHourlyRate(e.target.value)}
              className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
              required
            />
          </div>

          <div>
            <label className="block text-gray-700 mb-1">Hours Worked:</label>
            <input
              type="number"
              value={hoursWorked}
              onChange={(e) => setHoursWorked(e.target.value)}
              className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
              required
            />
          </div>

          <div>
            <label className="block text-gray-700 mb-1">
              Pension % (optional):
            </label>
            <input
              type="number"
              value={pension}
              onChange={(e) => setPension(e.target.value)}
              className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div>
            <label className="block text-gray-700 mb-1">
              Other Deductions (optional):
            </label>
            <input
              type="number"
              value={otherDeductions}
              onChange={(e) => setOtherDeductions(e.target.value)}
              className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <button
            type="submit"
            className="w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600 transition"
          >
            Calculate
          </button>
        </form>

        {result && (
          <div className="mt-6 bg-gray-50 p-4 rounded border border-gray-200">
            <h2 className="text-xl font-bold mb-2">
              Net Salary: {result.netSalary.toFixed(2)} DKK
            </h2>
            <p>AM-bidrag: {result.amBidrag.toFixed(2)} DKK</p>
            <p>Tax: {result.tax.toFixed(2)} DKK</p>
            <p>Pension: {result.pension.toFixed(2)} DKK</p>
            <p>Union Fee: {result.unionFee.toFixed(2)} DKK</p>
            <p>Other Deductions: {result.otherDeductions.toFixed(2)} DKK</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
