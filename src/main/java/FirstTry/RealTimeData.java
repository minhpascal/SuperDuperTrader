package FirstTry;

/**
 * Created by khalida on 1/28/2016.
 */
// Import Java utilities and Interactive Brokers API
import java.util.Vector;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.TagValue;
import com.ib.client.CommissionReport;
import com.ib.client.UnderComp;

public class RealTimeData implements EWrapper {

    //Keep track of the next order ID
    private int nextOrderID = 0;

    //The IB API Client Socket obj
    private EClientSocket client = null;

    public RealTimeData() {
        //Create a new EClientSocket obj
        client = new EClientSocket(this);
        //Connect to the TWS or IB Gateway application
        //Leave null for localhost
        //Port Number(should match TWS/IB gateway configuration)
        client.eConnect(null, 7497, 0);

        //Pause here for connection to complete
        try {
            while(!(client.isConnected()));
        } catch(Exception e) {
        }

        //Create a new contract - could seperate this process into an independent class
        Contract contract = new Contract();
        contract.m_symbol = "EUR";
        contract.m_exchange = "IDEALPRO";
        contract.m_secType = "CASH";
        contract.m_currency = "USD";

        //Create a TagValue list
        Vector<TagValue> mktDataOptions = new Vector<TagValue>();

        //Make a call to reqMktData to start off data retrieval with parameters:
        //ConID - Connection Identifier
        //Contract - the financial instrument we are requesting data on
        //Ticks - any custom tick alues we are looking for (null in this case)
        //Snapshot - false give us streaming data, true gives one data snapshot
        //MarketDataOptions - tagValue list of additional options
        client.reqMktData(0, contract, null, false, mktDataOptions);

        //at this point our call is done and any market data events
        //will be returned bia the ticket price method

    }

    public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {

    }

    public void tickSize(int tickerId, int field, int size) {

    }

    public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {

    }

    public void tickGeneric(int tickerId, int tickType, double value) {

    }

    public void tickString(int tickerId, int tickType, String value) {

    }

    public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {

    }

    public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {

    }

    public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {

    }

    public void openOrderEnd() {

    }

    public void updateAccountValue(String key, String value, String currency, String accountName) {

    }

    public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {

    }

    public void updateAccountTime(String timeStamp) {

    }

    public void accountDownloadEnd(String accountName) {

    }

    public void nextValidId(int orderId) {

    }

    public void contractDetails(int reqId, ContractDetails contractDetails) {

    }

    public void bondContractDetails(int reqId, ContractDetails contractDetails) {

    }

    public void contractDetailsEnd(int reqId) {

    }

    public void execDetails(int reqId, Contract contract, Execution execution) {

    }

    public void execDetailsEnd(int reqId) {

    }

    public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {

    }

    public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {

    }

    public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {

    }

    public void managedAccounts(String accountsList) {

    }

    public void receiveFA(int faDataType, String xml) {

    }

    public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP, boolean hasGaps) {

    }

    public void scannerParameters(String xml) {

    }

    public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {

    }

    public void scannerDataEnd(int reqId) {

    }

    public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {

    }

    public void currentTime(long time) {

    }

    public void fundamentalData(int reqId, String data) {

    }

    public void deltaNeutralValidation(int reqId, UnderComp underComp) {

    }

    public void tickSnapshotEnd(int reqId) {

    }

    public void marketDataType(int reqId, int marketDataType) {

    }

    public void commissionReport(CommissionReport commissionReport) {

    }

    public void position(String account, Contract contract, int pos, double avgCost) {

    }

    public void positionEnd() {

    }

    public void accountSummary(int reqId, String account, String tag, String value, String currency) {

    }

    public void accountSummaryEnd(int reqId) {

    }

    public void verifyMessageAPI(String apiData) {

    }

    public void verifyCompleted(boolean isSuccessful, String errorText) {

    }

    public void displayGroupList(int reqId, String groups) {

    }

    public void displayGroupUpdated(int reqId, String contractInfo) {

    }

    public void error(Exception e) {

    }

    public void error(String str) {

    }

    public void error(int id, int errorCode, String errorMsg) {

    }

    public void connectionClosed() {

    }
}
