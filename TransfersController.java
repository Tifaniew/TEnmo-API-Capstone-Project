package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransfersDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransfersController {
    private TransfersDao transfersDao;

    public TransfersController(TransfersDao transfersDao) {
        this.transfersDao = transfersDao;
    }

    @RequestMapping(value = "account/transfers/{id}", method = RequestMethod.GET)
    public List<Transfer> allTransfers(@PathVariable int id) {
        List<Transfer> transfers = transfersDao.allTransfers(id);
        return transfers;
    }

    @RequestMapping(path = "transfers/{id}", method = RequestMethod.GET)
    public Transfer transferById(@PathVariable int id) {
        Transfer transfer = transfersDao.transferById(id);
        return transfer;
    }

    @RequestMapping(path = "transfer", method = RequestMethod.POST)
    public String sendTransfer(@RequestBody Transfer transfer) {
        String results = transfersDao.sendTransfer(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
        return results;
    }

    @RequestMapping(path = "request", method = RequestMethod.POST)
    public String requestTransfer(@RequestBody Transfer transfer) {
        String results = transfersDao.requestTransfer(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
        return results;

    }
    @RequestMapping(value = "request/{id}", method = RequestMethod.GET)
    public List<Transfer> allTransferRequest(@PathVariable int id) {
        List<Transfer> list = transfersDao.pendingTransfers(id);
        return list;
    }
    @RequestMapping(path = "transfer/status/{statusId}", method = RequestMethod.PUT)
    public String updateRequest(@RequestBody Transfer transfer, @PathVariable int statusId) {
        String update = transfersDao.updateTransferStatus(transfer, statusId);
        return update;

    }
    @RequestMapping(path = "transfers/create/{fromId}/{toId}/{amount}", method = RequestMethod.POST)
    public void createTransfer(@PathVariable long fromId,
                                  @PathVariable long toId,
                                  @PathVariable double amount) {
        transfersDao.create(fromId, toId, amount);
    }
    }
