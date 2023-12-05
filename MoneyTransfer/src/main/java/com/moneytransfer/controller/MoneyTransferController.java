@RestController
public class MoneyTransferController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    /**
     * Send money
     *
     * @param jsonRequest
     * @return
     */
    @PostMapping("/api/send-money")
    public ResponseEntity<Object> sendMoney(@RequestBody JsonRequest jsonRequest) {
        ResponseEntity<Object> validationResponse = validateSendMoneyRequest(jsonRequest);
        if (validationResponse != null) {
            return validationResponse;
        }

        MoneyTransfer moneyTransfer = moneyTransferService.sendMoney(jsonRequest);
        return ResponseEntity.ok(moneyTransfer);
    }

    private ResponseEntity<Object> validateSendMoneyRequest(JsonRequest jsonRequest) {
        if (!"EUR".equals(jsonRequest.getCurrency())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("We only accept EUR currency");
        }
        if (jsonRequest.getAmount() < -100000000) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount must not be lower than -100000000 EUR");
        }
        if (jsonRequest.getAmount() > 100000000) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount must not be larger than 100000000 EUR");
        }
        return null;
    }

    /**
     * Get all money transactions
     *
     * @return
     */
    @GetMapping("/api/money-transactions")
    public ResponseEntity<Object> getAllMoneyTransactions() {
        return ResponseEntity.ok(moneyTransferService.findAll());
    }
}
