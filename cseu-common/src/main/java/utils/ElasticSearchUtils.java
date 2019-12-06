package utils;

import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;

import java.util.List;

/**
 * @author xueylf
 * @title: ElasticSearchUtils
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/614:38
 * version 1.0
 */
public class ElasticSearchUtils {
    private ElasticsearchTemplate elasticsearchTemplate;


    public ElasticSearchUtils(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }


    public List<Object> queryData(QueryBuilder queryBuilder) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        return elasticsearchTemplate.queryForList(searchQuery, Object.class);
    }

    public String setData(IndexQuery indexQuery) {
        return elasticsearchTemplate.index(indexQuery);
    }

    public int updateData(UpdateQuery updateQuery) {
        UpdateResponse response = elasticsearchTemplate.update(updateQuery);
        return response.status().getStatus();
    }

    public void deletData(DeleteQuery deleteQuery) {
        elasticsearchTemplate.delete(deleteQuery);
    }
}
