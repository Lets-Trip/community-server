package trip.community.util;

import jakarta.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter implements AttributeConverter<List<String>, String> {
  private static final String SPLIT_CHAR=",";

  // DB 테이블에 들어갈 때 적용됨
  @Override
  public String convertToDatabaseColumn(List<String> attribute){
    if(attribute == null){
      return null;
    }
    return attribute.stream().map(String::valueOf).collect(Collectors.joining(SPLIT_CHAR));
  }

  // DB 테이블의 데이터를 Object에 매핑시킬 때 적용됨
  @Override
  public List<String> convertToEntityAttribute(String dbData){
    if(dbData == null){
      return null;
    }
    return Arrays.stream(dbData.split(SPLIT_CHAR))
        .collect(Collectors.toList());
  }
}
