package eco.data.m3.routing.mnode;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import eco.data.m3.net.core.MId;
import eco.data.m3.routing.MHost;
import eco.data.m3.routing.MNode;
import eco.data.m3.routing.core.Content;

public class RoutingTableStateTest {
    
    class RoutingTableStateTestClass{
		MHost host = new MHost();

        MNode[] kads;

        public int numKads = 10;
    	
    	public RoutingTableStateTestClass() throws IOException {
	
	        /* Setting up Kad networks */
	        kads = new MNode[numKads];
	
	        kads[0] = host.createNode("user0", new MId("HRF456789SD584567460"));
	        kads[1] = host.createNode("user1", new MId("ASF456789475DS567461"));
	        kads[2] = host.createNode("user2", new MId("AFG45678947584567462"));
	        kads[3] = host.createNode("user3", new MId("FSF45J38947584567463"));
	        kads[4] = host.createNode("user4", new MId("ASF45678947584567464"));
	        kads[5] = host.createNode("user5", new MId("GHF4567894DR84567465"));
	        kads[6] = host.createNode("user6", new MId("ASF45678947584567466"));
	        kads[7] = host.createNode("user7", new MId("AE345678947584567467"));
	        kads[8] = host.createNode("user8", new MId("ASAA5678947584567468"));
	        kads[9] = host.createNode("user9", new MId("ASF456789475845674U9"));
	
	        for (int i = 1; i < numKads; i++)
	        {
	            kads[i].join(kads[0].getNodeId());
	        }
    	}

        public Content putContent(String content, MNode owner)
        {
        	Content c = null;
            try
            {
                c = new Content(owner.getName(), "Some Data");
                owner.put(c);
                return c;
            }
            catch (IOException e)
            {
                System.err.println("Error whiles putting content " + content + " from owner: " + owner.getName());
            }

            return c;
        }

        public void shutdownKad(MNode kad)
        {
            try
            {
            	host.shutdownNode(kad, false);
            }
            catch (IOException ex)
            {
                System.err.println("Error whiles shutting down node with owner: " + kad.getName());
            }
        }

        public void printRoutingTable(int kadId)
        {
            System.out.println(kads[kadId].getRoutingTable());
        }

        public void printRoutingTables()
        {
            for (int i = 0; i < numKads; i++)
            {
                this.printRoutingTable(i);
            }
        }

        public void printStorage(int kadId)
        {
            System.out.println(kads[kadId].getDHT());
        }

        public void printStorage()
        {
            for (int i = 0; i < numKads; i++)
            {
                this.printStorage(i);
            }
        }

    	
    }

	@Test
	public void test() throws IOException {

		RoutingTableStateTestClass rtss = new RoutingTableStateTestClass();

        try
        {
            rtss.printRoutingTables();

            /* Lets shut down a node to test the node removal operation */
            System.out.println("Shutdown : "+ rtss.kads[3].getName());
            rtss.shutdownKad(rtss.kads[3]);

            rtss.putContent("Content owned by kad0", rtss.kads[0]);
            rtss.printStorage();

            Thread.sleep(1000);

            /* kad3 should be removed from their routing tables by now. */
            rtss.printRoutingTables();
        }
        catch (InterruptedException ex)
        {

        }

//        Scanner sc = new Scanner(System.in);
//        while (true)
//        {
//            System.out.println("\n\n ************************* Options **************************** \n");
//            System.out.println("1 i - Print routing table of node i");
//            int val1 = sc.nextInt();
//            int val2 = sc.nextInt();
//
//            switch (val1)
//            {
//                case 1:
//                    rtss.printRoutingTable(val2);
//                    break;
//            }
//        }

	}


}
