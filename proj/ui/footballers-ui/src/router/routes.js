import UrlPath from "../constans/UrlPath";
import TeamsPage from "../pages/TeamsPage";
import PlayersPage from "../pages/PlayersPage";
import FormationPage from "../pages/FormationsPage";

export const routes = [
    {path: UrlPath.Teams, element: <TeamsPage/>, exact: true},
    {path: UrlPath.Players, element: <PlayersPage/>, exact: true},
    {path: UrlPath.Formations, element: <FormationPage/>, exact: true}
]