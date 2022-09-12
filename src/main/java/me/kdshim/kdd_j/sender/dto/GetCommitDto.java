package me.kdshim.kdd_j.sender.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetCommitDto {
    String url;
    String sha;
    String node_id;
    String html_url;
    String comments_url;
    Commit commit;
    Author author;
    Commiter committer;
    List<Parent> parents;

    @Override
    public String toString() {
        return "GetCommitDto{" +
                "url='" + url + '\'' +
                ", sha='" + sha + '\'' +
                ", node_id='" + node_id + '\'' +
                ", html_url='" + html_url + '\'' +
                ", comments_url='" + comments_url + '\'' +
                ", commit=" + commit +
                ", author=" + author +
                ", committer=" + committer +
                ", parents=" + parents +
                '}';
    }

    @Data
    public static class Commit {
        String url;
        Author author;
        Commiter commiter;
        String message;
        Tree tree;
        int comment_count;
        Verification verification;

        @Data
        public static class Author {
            String name;
            String email;
            String date;
        }

        @Data
        public static class Commiter {
            String name;
            String email;
            String date;
        }

        @Data
        public static class Tree {
            String url;
            String sha;
        }

        @Data
        public static class Verification {
            boolean verified;
            String reason;
            //이 밑에 2개는 null로 오긴하는데 다른거일수도?
            String signature;
            String payload;
        }
    }

    @Data
    public static class Author{
        String login;
        String id;
        String node_id;
        String avatar_url;
        String gravatar_id;
        String url;
        String html_url;
        String followers_url;
        String following_url;
        String gists_url;
        String starred_url;
        String subscriptions_url;
        String organizations_url;
        String repos_url;
        String events_url;
        String received_events_url;
        String type;
        boolean site_admin;
    }

    @Data
    public static class Commiter {
        String login;
        String id;
        String node_id;
        String avatar_url;
        String gravatar_id;
        String url;
        String html_url;
        String followers_url;
        String following_url;
        String starred_rul;
        String subscriptions_url;
        String organizations_url;
        String repos_url;
        String events_url;
        String received_events_url;
        String type;
        String site_admin;
    }

    @Data
    public static class Parent {
        String url;
        String sha;
    }
}

