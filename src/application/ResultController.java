package application;

import domain.Result;
import persistence.ResultRepository;

public class ResultController {

	public ResultDto createResult(ResultDto resultdto) throws Exception {
		Result result = new Result(resultdto);
		ResultRepository.storeResult(result);
		return new ResultDto(result);
	}
	
	public ResultDto updateResult(String resultId, ResultDto resultdto) throws Exception{
		Result result = ResultRepository.getResult(resultId);
		result.updateResult(resultdto);
		ResultRepository.updateResult(result);
		return new ResultDto(result);
	}
	
	public ResultDto getResult(String resultId) throws Exception {
		Result result= ResultRepository.getResult(resultId);
		return new ResultDto(result);
	}
}
