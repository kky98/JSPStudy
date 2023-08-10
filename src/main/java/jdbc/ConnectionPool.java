package jdbc;
import java.sql.Connection;
import java.sql.SQLException;
// connectionfactory 로 부터 maxConn 수량만큼 
// connection 객체를 미리 생성해서 풀(pool)에 보관 관리 하는 클래스
import java.util.Vector;

public class ConnectionPool {
	//Vector: 동기화(Synchronized)가 적용된 ArrayList	
	private static Vector<Connection> pool=new Vector<>();
	private static ConnectionPool instance = new ConnectionPool();
	// 싱글톤 
	public static ConnectionPool getInstance() {
		return instance;
	}
	private ConnectionPool() {
		try {
			initPool(); // 클래스를 인스턴스화 할때 initPool()을 호출하여 
			            // 풀을 초기화
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 풀에서 사용 가능한 데이터베이스 연결을 가져오는 메서드
	// 가능한 연결이 없을경우 wait() 호출 
	public synchronized Connection getConnection() {
		if(pool.size() ==0) {
			try {
				System.out.println("가능한 연결이 없어요... wait..");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}
	// 사용이 끝난 연결은 풀에 다시 반환하는 메서드 
	// 연결을 풀에 추가하고, 대기 중인 다른 스레드가 있다면 notify()로 사용
	public synchronized void releaseConnection(Connection conn) {
		  System.out.println("사용 후 pool에 담기");
		  pool.add(conn);
		  notify(); 
	}
	// 풀 내의 모든 데이터베이스 연결을 닫는 메서드(전체 종료시)
	private synchronized void destroyPool() throws SQLException {
		 for(int i = 0 ; i < pool.size(); i++) {
			 pool.get(i).close(); // connection 하나씩 닫기
		 }
		 pool.clear(); // 비우기 
	}
	// 풀 초기화하는 메서드 
	private synchronized void initPool() throws SQLException {
		 destroyPool();
		 ConnectionFactory factory = ConnectionFactory.getInstance();
		 int maxConn = factory.getMaxConn();
		 for(int i = 0 ; i < maxConn; i++) {
			 pool.add(factory.getConnection());  //프로퍼티maxConn수량만큼
		 }
	}
}
