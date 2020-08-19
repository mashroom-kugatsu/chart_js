package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetChartData
 */
@WebServlet("/GetChartData")
public class GetChartData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data[][] = csvToArray("sample2.csv");
		System.out.println(data[1][2]);

		// セッションスコープに配列データを格納
		HttpSession session = request.getSession();
		session.setAttribute("data", data);

		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data[][] = csvToArray("sample2.csv");
		System.out.println(data[1][2]);

		// セッションスコープに配列データを格納
		HttpSession session = request.getSession();
		session.setAttribute("data", data);

		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);

	}

	// CSVを2次元配列として返すメソッド
	public String[][] csvToArray(String fileName) {

		String fileDir = "C:\\eclipse-jee-2019-09\\workspace_chart_js\\data";
		String filePath = fileDir + "\\" + fileName;
		String[][] data = null;

		try {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));

			data = new String[29][];
			String line = br.readLine();
			for (int row = 0; line != null; row++) {
				data[row] = line.split(",", 0);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
