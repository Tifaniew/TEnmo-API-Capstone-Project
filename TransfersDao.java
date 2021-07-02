package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransfersDao {

   List<Transfer> allTransfers(int userId);
   Transfer transferById(int transferId);
   String sendTransfer (long accountFrom, long accountTo, double amount);
   String requestTransfer (long accountFrom, long accountTo, double amount);
   List<Transfer> pendingTransfers(int userId);
   String updateTransferStatus(Transfer transfer, int transferStatusId);
   void create(long fromId, long toId, double amount);
}
