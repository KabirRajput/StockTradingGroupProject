import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdm.legendtrading.springmvc.dao.AccountDao;
import com.fdm.legendtrading.springmvc.dao.AssetDao;
import com.fdm.legendtrading.springmvc.dao.TradeDao;
import com.fdm.legendtrading.springmvc.model.Account;
import com.fdm.legendtrading.springmvc.model.Asset;
import com.fdm.legendtrading.springmvc.model.Position;
import com.fdm.legendtrading.springmvc.model.PositionId;
import com.fdm.legendtrading.springmvc.model.Trade;
import com.fdm.legendtrading.springmvc.service.AccountService;
import com.fdm.legendtrading.springmvc.service.AssetService;
import com.fdm.legendtrading.springmvc.service.TradeService;
import com.fdm.legendtrading.springmvc.service.PositionService;

public class Runner {


public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
TradeService ts =  context.getBean("tradeService",TradeService.class);
AccountService as =  context.getBean("accountService",AccountService.class);
PositionService ps = context.getBean("positionService",PositionService.class);
AssetService ats = context.getBean("assetService",AssetService.class);


Account a1= new Account("Trade","Trading Account");
Account a2= new Account("Trade","Trading Account");
Account a3= new Account("Trade","Trading Account");
Account a4= new Account("Trade","Trading Account");
Account a5= new Account("Trade","Trading Account");
Account a6= new Account("Trade","Trading Account");
Account a7= new Account("Trade","Trading Account");
Account a8= new Account("Trade","Trading Account");
Account a9= new Account("Trade","Trading Account");
Account a10= new Account("Trade","Trading Account");
as.addAccount(a1);
as.addAccount(a2);
as.addAccount(a3);
as.addAccount(a4);
as.addAccount(a5);
as.addAccount(a6);
as.addAccount(a7);
as.addAccount(a8);
as.addAccount(a9);
as.addAccount(a10);

Asset asset1=new Asset("COMS","Smartspace Software Plc","Stocks");
Asset asset2=new Asset("KDE","4Kids Entertainment","Stocks");
Asset asset3=new Asset("SVNX","724 Solutions Inc","Stocks");
Asset asset4=new Asset("ABT","Abbott Laboratories","Stocks");
Asset asset5=new Asset("ANF","Abercrombie & Fitch Co.","Stocks");
Asset asset6=new Asset("ABGX","Abgenix Inc.","Stocks");
Asset asset7=new Asset("ADPT","Adeptus Health Inc.","Stocks");
Asset asset8=new Asset("ADBE","Adobe Inc","Stocks");
Asset asset9=new Asset("ADIC","Advanced Digital Information Co.","Stocks");
Asset asset10=new Asset("ARW","Arrow Electronics Inc.","Stocks");
ats.addAsset(asset1);
ats.addAsset(asset2);
ats.addAsset(asset3);
ats.addAsset(asset4);
ats.addAsset(asset5);
ats.addAsset(asset6);
ats.addAsset(asset7);
ats.addAsset(asset8);
ats.addAsset(asset9);
ats.addAsset(asset10);


PositionId pi1= new PositionId(asset1.getSymbol(),a1.getAccountId());
PositionId pi2= new PositionId(asset2.getSymbol(),a2.getAccountId());
PositionId pi3= new PositionId(asset3.getSymbol(),a3.getAccountId());
PositionId pi4= new PositionId(asset4.getSymbol(),a4.getAccountId());
PositionId pi5= new PositionId(asset5.getSymbol(),a5.getAccountId());
PositionId pi6= new PositionId(asset6.getSymbol(),a6.getAccountId());
PositionId pi7= new PositionId(asset7.getSymbol(),a7.getAccountId());
PositionId pi8= new PositionId(asset8.getSymbol(),a8.getAccountId());
PositionId pi9= new PositionId(asset9.getSymbol(),a9.getAccountId());
PositionId pi10= new PositionId(asset10.getSymbol(),a10.getAccountId());

Position p1 = new Position(pi1, 1000);
Position p2 = new Position(pi2, 1000);
Position p3 = new Position(pi3, 1000);
Position p4 = new Position(pi4, 300);
Position p5 = new Position(pi5, 600);
Position p6 = new Position(pi6, 1000);
Position p7 = new Position(pi7, 100);
Position p8 = new Position(pi8, 10);
Position p9 = new Position(pi9, 100);
Position p10 = new Position(pi10, 2000);
ps.addPosition(p1);
ps.addPosition(p2);
ps.addPosition(p3);
ps.addPosition(p4);
ps.addPosition(p5);
ps.addPosition(p6);
ps.addPosition(p7);
ps.addPosition(p8);
ps.addPosition(p9);
ps.addPosition(p10);
}
}